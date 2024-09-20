# Ensure the script runs as Administrator
if (-not ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator"))
{
    Start-Process powershell -Verb runAs -ArgumentList ('-File', $myinvocation.MyCommand.Path)
    Exit
}

# Download the MySQL installer from the official website 
$mysqlInstallerPath = "H:\Installers\mysql-installer-commun8\mysql-installer-community-8.0.39.0.msi"
(New-Object System.Net.WebClient).DownloadFile($mysqlInstallerUrl, $mysqlInstallerPath)

# Install MySQL Server using the installer
Start-Process msiexec.exe -ArgumentList "/i $mysqlInstallerPath /quiet /norestart" -Wait

# Set MySQL root password and start MySQL service
$mysqlPassword = "She8$starfire989"  # Replace with your desired root password
$mysqlInstallPath = "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysqladmin.exe"
if (Test-Path $mysqlInstallPath) {
    & $mysqlInstallPath -u root password $mysqlPassword
    Start-Service MySQL80
} else {
    Write-Host "MySQL installation failed or path not found."
}

# Function to pin an application to the taskbar
function Pin-AppToTaskbar {
    param (
        [string]$appPath
    )
    $shell = New-Object -ComObject shell.application
    $folder = $shell.Namespace((Get-Item $appPath).DirectoryName)
    $item = $folder.ParseName((Get-Item $appPath).Name)
    $verb = $item.Verbs() | Where-Object { $_.Name -eq "Pin to Tas&kbar" }
    if ($verb) {
        $verb.DoIt()
    } else {
        Write-Host "App already pinned or pin option not available for $appPath"
    }
}

# Pin MySQL Workbench to the taskbar if installed
$mysqlWorkbenchPath = "C:\Program Files\MySQL\MySQL Workbench 8.0 CE\MySQLWorkbench.exe"
if (Test-Path $mysqlWorkbenchPath) {
    Pin-AppToTaskbar $mysqlWorkbenchPath
} else {
    Write-Host "MySQL Workbench executable not found at $mysqlWorkbenchPath"
}

# Output a message indicating the setup is complete
Write-Host "MySQL Server 8.0 installation and taskbar pinning complete."
