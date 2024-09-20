# Ensure the script runs as Administrator
if (-not ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator"))
{
    Start-Process powershell -Verb runAs -ArgumentList ('-File', $myinvocation.MyCommand.Path)
    Exit
}

# Update system packages
Install-PackageProvider -Name NuGet -Force
Install-Module -Name PowerShellGet -Force -AllowClobber

# Install Chocolatey (a package manager for Windows)
Set-ExecutionPolicy Bypass -Scope Process -Force
[System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072
iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

# Install OpenJDK 17 (Java 17)
choco install openjdk17 -y

# Set JAVA_HOME environment variable
[Environment]::SetEnvironmentVariable('JAVA_HOME', 'C:\Program Files\OpenJDK\openjdk-17', 'Machine')
$env:Path += ';C:\Program Files\OpenJDK\openjdk-17\bin'
[Environment]::SetEnvironmentVariable('Path', $env:Path, 'Machine')

# Install MySQL Server
choco install mysql -y

# Set MySQL root password and start MySQL service
$mysqlPassword = "YourRootPassword"
& "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysqladmin.exe" -u root password $mysqlPassword
Start-Service MySQL80

# Install MySQL Workbench
choco install mysql.workbench -y

# Install Box Drive
$boxDriveInstallerUrl = "https://e3.boxcdn.net/desktop/pre-release/Box-x64.msi"  # Example URL, check for the latest version
$boxDriveInstallerPath = "C:\Installers\Box-x64.msi"
(New-Object System.Net.WebClient).DownloadFile($boxDriveInstallerUrl, $boxDriveInstallerPath)
Start-Process msiexec.exe -ArgumentList "/i $boxDriveInstallerPath /quiet" -Wait

# Install Git
choco install git -y

# Install Visual Studio Code (Optional, as a common IDE)
choco install vscode -y

# Install Eclipse IDE for Java Developers
choco install eclipse-java -y

# Install Spring Tools 4 for Eclipse (for Spring Boot Development)
$eclipsePluginUrl = "https://download.springsource.com/release/STS4/4.15.2.RELEASE/dist/e4.21/spring-tool-suite-4-4.15.2.RELEASE-e4.21.0-win32.win32.x86_64.zip"
$eclipsePluginZip = "C:\Installers\sts4.zip"
$eclipsePluginDir = "C:\Installers\sts4"

# Download and extract the Spring Tools 4 plugin
(New-Object System.Net.WebClient).DownloadFile($eclipsePluginUrl, $eclipsePluginZip)
Expand-Archive -Path $eclipsePluginZip -DestinationPath $eclipsePluginDir -Force

# Move the extracted files to the Eclipse dropins folder
Copy-Item -Path "$eclipsePluginDir\*" -Destination "C:\Program Files\Eclipse\dropins" -Recurse

# Add new users and set passwords
$adminUsername = "adminUser101"
$adminPassword = "theo19$Fighter"
$devUsername = "devUser89"
$devPassword = "huff$37Tittree"

# Create the admin user and add to Administrators group
net user $adminUsername $adminPassword /add
net localgroup Administrators $adminUsername /add

# Create the dev user
net user $devUsername $devPassword /add

# Download and set up the Spring Boot application (assuming it's available via a URL or you can upload it)
$applicationUrl = "http://example.com/mzquickattest.jar"  # Replace with your actual JAR file location
$applicationPath = "C:\MZQuickAttest\mzquickattest.jar"
(New-Object System.Net.WebClient).DownloadFile($applicationUrl, $applicationPath)

# Create a scheduled task to run the Spring Boot application on startup
$action = New-ScheduledTaskAction -Execute "java" -Argument "-jar $applicationPath"
$trigger = New-ScheduledTaskTrigger -AtStartup
Register-ScheduledTask -Action $action -Trigger $trigger -TaskName "Start MZQuickAttest Application"

# Output a message indicating the setup is complete
Write-Host "MZQuickAttest environment setup complete."
