# Ensure the script runs as Administrator
if (-not ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator"))
{
    Start-Process powershell -Verb runAs -ArgumentList ('-File', $myinvocation.MyCommand.Path)
    Exit
}

# Enable Remote Desktop
Write-Host "Enabling Remote Desktop..."
Set-ItemProperty -Path "HKLM:\System\CurrentControlSet\Control\Terminal Server" -Name "fDenyTSConnections" -Value 0

# Allow RDP through the firewall
Write-Host "Configuring Windows Firewall to allow Remote Desktop..."
Enable-NetFirewallRule -DisplayGroup "Remote Desktop"

# Optional: Set the RDP port (default is 3389)
$rdpPort = 3389  # Change this value if you want to use a different port
Set-ItemProperty -Path "HKLM:\System\CurrentControlSet\Control\Terminal Server\WinStations\RDP-Tcp" -Name "PortNumber" -Value $rdpPort

# Enable Network Level Authentication (NLA)
Write-Host "Enabling Network Level Authentication (NLA)..."
Set-ItemProperty -Path "HKLM:\System\CurrentControlSet\Control\Terminal Server\WinStations\RDP-Tcp" -Name "UserAuthentication" -Value 1

# Check if Remote Desktop Services role is installed on Windows Server
if (Get-WindowsFeature -Name "Remote-Desktop-Services" -ErrorAction SilentlyContinue) {
    Write-Host "Remote Desktop Services role is already installed."
} else {
    Write-Host "Installing Remote Desktop Services role..."
    Install-WindowsFeature -Name "Remote-Desktop-Services" -IncludeAllSubFeature -IncludeManagementTools
}

# Restart the Remote Desktop Services
Write-Host "Restarting Remote Desktop Services..."
Restart-Service -Name "TermService" -Force

Write-Host "Remote Desktop setup complete. You can now connect to this machine using Remote Desktop."
