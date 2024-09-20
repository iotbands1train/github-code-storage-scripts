# Ensure the script runs as Administrator
if (-not ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator"))
{
    Start-Process powershell -Verb runAs -ArgumentList ('-File', $myinvocation.MyCommand.Path)
    Exit
}

# Variables
$tomcatVersion = "10.1.28" # Updated Tomcat version
$tomcatServiceName = "Tomcat$tomcatVersion"
$installDir = "D:\Apache\Tomcat"  # Install location
$downloadUrl = "https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.28/bin/apache-tomcat-10.1.28.zip" # Correct URL
$tomcatZip = "$installDir\apache-tomcat-$tomcatVersion.zip"
$serviceBat = "$installDir\apache-tomcat-$tomcatVersion\bin\service.bat"
$webAppDir = "$installDir\apache-tomcat-$tomcatVersion\webapps\MyJavaApp"

# Create installation directory
if (-not (Test-Path $installDir)) {
    New-Item -Path $installDir -ItemType Directory -Force
    Write-Host "Created directory: $installDir"
}

# Download and extract Apache Tomcat
Write-Host "Downloading Apache Tomcat version $tomcatVersion..."
(New-Object System.Net.WebClient).DownloadFile($downloadUrl, $tomcatZip)

Write-Host "Extracting Apache Tomcat..."
Expand-Archive -Path $tomcatZip -DestinationPath $installDir -Force

# Install Tomcat as a Windows service
Write-Host "Installing Apache Tomcat as a Windows service..."
Start-Process -FilePath "cmd.exe" -ArgumentList "/c `"$serviceBat install`"" -Wait -NoNewWindow

# Check if the service was installed
if (Get-Service -Name $tomcatServiceName -ErrorAction SilentlyContinue) {
    # Set Tomcat service to start automatically
    Set-Service -Name $tomcatServiceName -StartupType Automatic
    Start-Service -Name $tomcatServiceName
    Write-Host "Tomcat service installed and started successfully."
} else {
    Write-Host "Failed to install Tomcat as a service."
}

# Create a basic Java web application
Write-Host "Setting up a basic Java web application..."
if (-not (Test-Path $webAppDir)) {
    New-Item -Path $webAppDir -ItemType Directory -Force
}

$htmlContent = @"
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to My Java App</title>
</head>
<body>
    <h1>Hello, world! Welcome to My Java App</h1>
</body>
</html>
"@
$indexPath = Join-Path $webAppDir "index.html"
$htmlContent | Set-Content -Path $indexPath

# Open firewall port for Tomcat (default is port 8080)
$tomcatPort = 8080
Write-Host "Configuring firewall to allow Tomcat traffic on port $tomcatPort..."
New-NetFirewallRule -DisplayName "Tomcat Port $tomcatPort" -Direction Inbound -Protocol TCP -LocalPort $tomcatPort -Action Allow

Write-Host "Apache Tomcat setup complete. You can access your Java app at http://localhost:$tomcatPort/MyJavaApp"
