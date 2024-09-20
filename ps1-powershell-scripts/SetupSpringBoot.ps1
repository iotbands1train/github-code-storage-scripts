# Ensure the script runs as Administrator
if (-not ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator"))
{
    Start-Process powershell -Verb runAs -ArgumentList ('-File', $myinvocation.MyCommand.Path)
    Exit
}

# Variables
$installDir = "D:\Tools"  # Base installation directory
$eclipseUrl = "https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2023-09/R/eclipse-jee-2023-09-R-win32-x86_64.zip"
$springToolsUrl = "https://download.springsource.com/release/STS4/4.15.2.RELEASE/dist/e4.25/spring-tool-suite-4-4.15.2.RELEASE-e4.25.0-win32.win32.x86_64.zip"
$eclipseZip = "$installDir\eclipse-jee-2023-09-R-win32-x86_64.zip"
$springToolsZip = "$installDir\spring-tool-suite-4-4.15.2.RELEASE-e4.25.0-win32.win32.x86_64.zip"
$eclipseDir = "$installDir\eclipse"
$springToolsDir = "$installDir\sts4"

# Create installation directory if it doesn't exist
if (-not (Test-Path $installDir)) {
    New-Item -Path $installDir -ItemType Directory -Force
    Write-Host "Created directory: $installDir"
}

# Download and extract Eclipse IDE
Write-Host "Downloading Eclipse IDE..."
(New-Object System.Net.WebClient).DownloadFile($eclipseUrl, $eclipseZip)

Write-Host "Extracting Eclipse IDE..."
Expand-Archive -Path $eclipseZip -DestinationPath $eclipseDir -Force

# Download and extract Spring Tools Suite
Write-Host "Downloading Spring Tools Suite..."
(New-Object System.Net.WebClient).DownloadFile($springToolsUrl, $springToolsZip)

Write-Host "Extracting Spring Tools Suite..."
Expand-Archive -Path $springToolsZip -DestinationPath $springToolsDir -Force

# Start Eclipse IDE
Write-Host "Starting Eclipse IDE..."
Start-Process "$eclipseDir\eclipse.exe"

Write-Host "Setup complete. You can now use Eclipse IDE with Spring Tools to create a Spring Boot project."
