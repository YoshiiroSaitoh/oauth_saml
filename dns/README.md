# DNS Infrastructure

家庭内 DNS / 認証実験環境用 Infrastructure as Code 管理ディレクトリ。

Raspberry Pi 上に構築した Pi-hole / dnsmasq を
Ansible により構成管理する。

---

## 目的

このディレクトリでは、家庭内 DNS と認証検証基盤を管理する。

主な用途は以下。

- ローカル開発用 DNS
- OIDC / SAML フェデレーション検証
- Keycloak 検証環境
- `*.test` ドメインによる名前解決
- 広告ブロック
- Reverse Proxy / HTTPS 検証
- WebAuthn / FIDO2 検証基盤

---

## 構成

```text
dns/
├── ansible.cfg
├── playbook.yml
├── inventory/
│   └── hosts.yml
│
├── resources/
│   └── id_rsa
│
└── roles/
    └── dnsmasq/
        ├── tasks/
        │   └── main.yml
        │
        ├── handlers/
        │   └── main.yml
        │
        └── templates/
            └── dnsmasq.conf.j2