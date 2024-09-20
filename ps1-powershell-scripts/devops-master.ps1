# Ensure the script runs as Administrator
if (-not ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator"))
{
    Start-Process powershell -Verb runAs -ArgumentList ('-File', $myinvocation.MyCommand.Path)
    Exit
}

# Update system packages and install Chocolatey
Install-PackageProvider -Name NuGet -Force
Install-Module -Name PowerShellGet -Force -AllowClobber
Set-ExecutionPolicy Bypass -Scope Process -Force
[System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072
iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

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

# Java Development Setup
function Setup-JavaDevEnvironment {
    Write-Host "Setting up Java DevOps environment..."
    choco install openjdk --version 17.0.2 -y
    choco install maven -y
    choco install gradle -y
    choco install eclipse-java -y

    # Pin Eclipse to the taskbar
    $eclipsePath = "C:\Program Files\Eclipse Foundation\eclipse.exe"
    if (Test-Path $eclipsePath) {
        Pin-AppToTaskbar $eclipsePath
    } else {
        Write-Host "Eclipse executable not found at $eclipsePath"
    }
}

# Python Development Setup
function Setup-PythonDevEnvironment {
    Write-Host "Setting up Python DevOps environment..."
    choco install python -y
    choco install pip -y
    choco install pycharm-community -y

    # Pin PyCharm to the taskbar
    $pycharmPath = "C:\Program Files\JetBrains\PyCharm Community Edition 2023.1\bin\pycharm64.exe"
    if (Test-Path $pycharmPath) {
        Pin-AppToTaskbar $pycharmPath
    } else {
        Write-Host "PyCharm executable not found at $pycharmPath"
    }
}

# C# Development Setup
function Setup-CSharpDevEnvironment {
    Write-Host "Setting up C# DevOps environment..."
    choco install visualstudio2022community -y --package-parameters "--add Microsoft.VisualStudio.Workload.CoreEditor --add Microsoft.VisualStudio.Workload.NetCoreTools --includeRecommended --includeOptional"

    # Pin Visual Studio to the taskbar
    $vsPath = "C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\IDE\devenv.exe"
    if (Test-Path $vsPath) {
        Pin-AppToTaskbar $vsPath
    } else {
        Write-Host "Visual Studio executable not found at $vsPath"
    }
}

# Frontend Development Setup
function Setup-FrontendDevEnvironment {
    Write-Host "Setting up Frontend DevOps environment..."
    choco install nodejs -y
    choco install yarn -y
    cho# Ensure the script runs as Administrator
if (-not ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator"))
{
    Start-Process powershell -Verb runAs -ArgumentList ('-File', $myinvocation.MyCommand.Path)
    Exit
}

# Update system packages and install Chocolatey
Install-PackageProvider -Name NuGet -Force
Install-Module -Name PowerShellGet -Force -AllowClobber
Set-ExecutionPolicy Bypass -Scope Process -Force
[System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072
iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

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

# Java Development Setup
function Setup-JavaDevEnvironment {
    Write-Host "Setting up Java DevOps environment..."
    choco install openjdk --version 17.0.2 -y
    choco install maven -y
    choco install gradle -y
    choco install eclipse-java -y

    # Pin Eclipse to the taskbar
    $eclipsePath = "C:\Program Files\Eclipse Foundation\eclipse.exe"
    if (Test-Path $eclipsePath) {
        Pin-AppToTaskbar $eclipsePath
    } else {
        Write-Host "Eclipse executable not found at $eclipsePath"
    }
}

# Python Development Setup
function Setup-PythonDevEnvironment {
    Write-Host "Setting up Python DevOps environment..."
    choco install python -y
    choco install pip -y
    choco install pycharm-community -y

    # Pin PyCharm to the taskbar
    $pycharmPath = "C:\Program Files\JetBrains\PyCharm Community Edition 2023.1\bin\pycharm64.exe"
    if (Test-Path $pycharmPath) {
        Pin-AppToTaskbar $pycharmPath
    } else {
        Write-Host "PyCharm executable not found at $pycharmPath"
    }
}

# C# Development Setup
function Setup-CSharpDevEnvironment {
    Write-Host "Setting up C# DevOps environment..."
    choco install visualstudio2022community -y --package-parameters "--add Microsoft.VisualStudio.Workload.CoreEditor --add Microsoft.VisualStudio.Workload.NetCoreTools --includeRecommended --includeOptional"

    # Pin Visual Studio to the taskbar
    $vsPath = "C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\IDE\devenv.exe"
    if (Test-Path $vsPath) {
        Pin-AppToTaskbar $vsPath
    } else {
        Write-Host "Visual Studio executable not found at $vsPath"
    }
}

# Frontend Development Setup
function Setup-FrontendDevEnvironment {
    Write-Host "Setting up Frontend DevOps environment..."
    choco install nodejs -y
    choco install yarn -y
    choco install vscode -y

    # Pin VS Code to the taskbar
    $vscodePath = "C:\Program Files\Microsoft VS Code\Code.exe"
    if (Test-Path $vscodePath) {
        Pin-AppToTaskbar $vscodePath
    } else {
        Write-Host "Visual Studio Code executable not found at $vscodePath"
    }
}

# Run all setups 
Setup-JavaDevEnvironment
Setup-PythonDevEnvironment
Setup-CSharpDevEnvironment
Setup-FrontendDevEnvironment

Write-Host "DevOps environment setup complete."
co install vscode -y

    # Pin VS Code to the taskbar
    $vscodePath = "C:\Program Files\Microsoft VS Code\Code.exe"
    if (Test-Path $vscodePath) {
        Pin-AppToTaskbar $vscodePath
    } else {
        Write-Host "Visual Studio Code executable not found at $vscodePath"
    }
}

# Run all setups
Setup-JavaDevEnvironment
Setup-PythonDevEnvironment
Setup-CSharpDevEnvironment
Setup-FrontendDevEnvironment

Write-Host "DevOps environment setup complete."
