SUMMARY = "Linux image"
DESCRIPTION = "Autoscope base OS"
LICENCE = "GPL"
export IMAGE_BASENAME = "autoscope-console-image"

inherit core-image

#IMAGE_FEATURES += "splash"
#SPLASH = "psplash-raspberrypi"
#IMAGE_FEATURES += "ssh-server-dropbear splash"
IMAGE_FEATURES += "ssh-server-openssh splash"

inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P estei root; \
	useradd -P estei autoscope; \
	useradd -P estei admin; "

CORE = " \
	kernel-modules \
	"

# was useful to connect a LAN (MASTER_SE, home)
# very heavy (+300Mb), connman seems able to do the same much more lightly
CONNECTIVITY = " \
	linux-firmware \
	i2c-tools \
	python-smbus \
	bridge-utils \
	hostapd \
	iptables \
	wpa-supplicant \
"

HOTSPOT = " \
	iptables \
	connman \
	connman-client \
	connman-conf \
"

SFTP = " \
	openssh-sftp-server \
"

FTP = " \
	vsftpd \
"

# start cam : raspivid -t 0
CAMERA = " \
	userland \
"

#	a4988-mod
IMAGE_INSTALL += " \
	${CAMERA} \
	${FTP} \
	${HOTSPOT} \
	hello-mod \
	i2c-tools \
"

#DISTRO_FEATURES += "wifi"
#MACHINE_FEATURES += "wifi"
#IMAGE_INSTALL_remove = " \
#	bluetooth \
#	bluez \
#"

hotspot() {
	echo 'net.ipv4.ip_forward = 1' >> ${IMAGE_ROOTFS}/etc/sysctl.conf
}

ROOTFS_POSTPROCESS_COMMAND += " hotspot; "
