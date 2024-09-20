# PowerShell script to install LibreOffice and Google Chrome

# Define download URLs
$libreOfficeUrl = "https://download.documentfoundation.org/libreoffice/stable/7.6.0/win/x86_64/LibreOffice_7.6.0_Win_x64.msi"
$chromeUrl = "https://dl.google.com/chrome/install/latest/chrome_installer.exe"

# Define file paths for downloaded installers
$libreOfficeInstaller = "$env:TEMP\LibreOffice_7.6.0_Win_x64.msi"
$chromeInstaller = "$env:TEMP\chrome_installer.exe"

# Download LibreOffice installer
Write-Output "Downloading LibreOffice..."
Invoke-WebRequest -Uri $libreOfficeUrl -OutFile $libreOfficeInstaller

# Download Google Chrome installer
Write-Output "Downloading Google Chrome..."
Invoke-WebRequest -Uri $chromeUrl -OutFile $chromeInstaller

# Install LibreOffice silently
Write-Output "Installing LibreOffice..."
Start-Process msiexec.exe -ArgumentList "/i `"$libreOfficeInstaller`" /quiet /norestart" -NoNewWindow -Wait

# Install Google Chrome silently
Write-Output "Installing Google Chrome..."
Start-Process $chromeInstaller -ArgumentList "/silent /install" -NoNewWindow -Wait

# Clean up
Write-Output "Cleaning up installation files..."
Remove-Item $libreOfficeInstaller -Force
Remove-Item $chromeInstaller -Force

Write-Output "Installation of LibreOffice and Google Chrome completed successfully."