$wslIp = wsl hostname -I | ForEach-Object {
    ($_ -split ' ') |
    Where-Object { $_ -match '^172\.' } |
    Select-Object -First 1
}

$ports = @(8080, 3000, 8443)

foreach ($port in $ports) {

    Write-Host "Forward $port -> $wslIp`:$port"

    netsh interface portproxy delete v4tov4 listenaddress=0.0.0.0 listenport=$port

    netsh interface portproxy add v4tov4 listenaddress=0.0.0.0 listenport=$port connectaddress=$wslIp connectport=$port
}

netsh interface portproxy show all