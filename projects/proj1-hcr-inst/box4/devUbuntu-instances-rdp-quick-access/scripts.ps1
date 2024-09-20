$Password = "ii88Yub$zero"

$RDPFiles = @(
    "Y:\projects\proj1-hcr-inst\box4\devUbuntu-instances-rdp-quick-access\HCR-Fincen-1Dev-instance.rdp",
    "Y:\projects\proj1-hcr-inst\box4\devUbuntu-instances-rdp-quick-access\HCR-Fincen-2Qa-instance.rdp",
    "Y:\projects\proj1-hcr-inst\box4\devUbuntu-instances-rdp-quick-access\HCR-Fincen-3PreProd-instance.rdp",
    "Y:\projects\proj1-hcr-inst\box4\devUbuntu-instances-rdp-quick-access\HCR-Fincen-4Prod-instance.rdp"
)

foreach ($RDPFile in $RDPFiles) {
    $EncryptedPassword = ConvertTo-SecureString $Password -AsPlainText -Force | ConvertFrom-SecureString
    Add-Content -Path $RDPFile -Value "password 51:b:$EncryptedPassword"
}
