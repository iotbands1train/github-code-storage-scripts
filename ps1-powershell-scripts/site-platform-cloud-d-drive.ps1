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

# Cloud Engineering Setup
function Setup-CloudEngineeringEnvironment {
    Write-Host "Setting up Cloud Engineering environment..."
    choco install awscli -y           # AWS CLI for managing AWS services
    choco install azure-cli -y        # Azure CLI for managing Azure services
    choco install google-cloud-sdk -y # Google Cloud SDK for managing Google Cloud Platform
    choco install terraform -y        # Terraform for infrastructure as code
    choco install packer -y           # Packer for building automated machine images
    choco install kubectl -y          # kubectl for managing Kubernetes clusters

    # Pin AWS CLI to the taskbar
    $awsCliPath = "D:\Program Files\Amazon\AWSCLIV2\aws.exe"
    if (Test-Path $awsCliPath) {
        Pin-AppToTaskbar $awsCliPath
    } else {
        Write-Host "AWS CLI executable not found at $awsCliPath"
    }
}

# Site Reliability Engineering (SRE) Setup
function Setup-SREEnvironment {
    Write-Host "Setting up Site Reliability Engineering (SRE) environment..."
    choco install prometheus -y       # Prometheus for monitoring and alerting
    choco install grafana -y          # Grafana for visualization and dashboards
    choco install ansible -y          # Ansible for configuration management and automation
    choco install docker-desktop -y   # Docker Desktop for containerization

    # Pin Docker to the taskbar
    $dockerPath = "D:\Program Files\Docker\Docker\Docker Desktop.exe"
    if (Test-Path $dockerPath) {
        Pin-AppToTaskbar $dockerPath
    } else {
        Write-Host "Docker executable not found at $dockerPath"
    }
}

# Platform Engineering Setup
function Setup-PlatformEngineeringEnvironment {
    Write-Host "Setting up Platform Engineering environment..."
    choco install jenkins -y          # Jenkins for CI/CD automation
    choco install vagrant -y          # Vagrant for managing development environments
    choco install consul -y           # Consul for service discovery and configuration
    choco install vault -y            # Vault for secrets management

    # Pin Jenkins to the taskbar
    $jenkinsPath = "D:\Program Files (x86)\Jenkins\jenkins.exe"
    if (Test-Path $jenkinsPath) {
        Pin-AppToTaskbar $jenkinsPath
    } else {
        Write-Host "Jenkins executable not found at $jenkinsPath"
    }
}

# Run all setups
Setup-CloudEngineeringEnvironment
Setup-SREEnvironment
Setup-PlatformEngineeringEnvironment

Write-Host "Cloud Engineering, SRE, and Platform Engineering environment setup complete."
