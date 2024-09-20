# Install the latest OpenJDK (Java Development Kit)
choco install openjdk --version 17.0.2 -y

# Set JAVA_HOME environment variable
$jdkPath = Get-ChildItem -Path "C:\Program Files\OpenJDK\" | Sort-Object LastWriteTime -Descending | Select-Object -First 1 | Select-Object -ExpandProperty FullName
[Environment]::SetEnvironmentVariable('JAVA_HOME', $jdkPath, 'Machine')
$env:Path += ";$jdkPath\bin"
[Environment]::SetEnvironmentVariable('Path', $env:Path, 'Machine')