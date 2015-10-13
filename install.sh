#!/bin/sh
yum install -y http://resources.ovirt.org/pub/yum-repo/ovirt-release35.rpm
yum install -y *.rpm

chmod 777 /usr/share/ovirt-engine/setup/bin/ovirt-engine-setup
chmod 777 /usr/share/ovirt-engine/bin/java-home
chmod 777 /usr/share/ovirt-engine/bin/*.sh
chmod 777 /usr/share/ovirt-engine/dbscripts/*.sh
chmod 777 /usr/share/ovirt-engine/services/ovirt-engine/*.py
chmod 777 /usr/share/ovirt-engine/services/ovirt-engine-notifier/*.py
chmod 777 /usr/share/ovirt-engine/services/ovirt-websocket-proxy/*.py
chmod 777 /usr/share/ovirt-engine/services/ovirt-fence-kdump-listener/*.py
chmod 777 /usr/share/ovirt-engine/setup/dbutils/*.sh
mkdir -p /var/kvmmgr
touch /var/kvmmgr/kmhw.inc
touch /var/kvmmgr/license.inc
chmod 777 /var/kvmmgr/kmhw.inc
chmod 777 /var/kvmmgr/license.inc

engine-setup --offline