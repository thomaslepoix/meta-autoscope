SUMMARY = "Linux image"
DESCRIPTION = "Autoscope base OS"
LICENCE = "GPL"
export IMAGE_BASENAME = "autoscope-console-image"

inherit core-image

#IMAGE_FEATURES += "splash"
#SPLASH = "psplash-raspberrypi"
#IMAGE_FEATURES += "ssh-server-dropbear splash"
IMAGE_FEATURES += "ssh-server-openssh splash"

# user autoscope	: FTP only
# user admin		: SSH only
# user root			: local only
inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P estei root; \
	useradd -P estei autoscope; \
	useradd -P estei admin; "

#CORE = " \
#	kernel-modules \
#	"

# was useful to connect a LAN (MASTER_SE, home)
# very heavy (+300Mb), connman seems able to do the same much more lightly
#CONNECTIVITY = " \
#	linux-firmware \
#	i2c-tools \
#	python-smbus \
#	bridge-utils \
#	hostapd \
#	iptables \
#	wpa-supplicant \
#"

HOTSPOT = " \
	iptables \
	connman \
	connman-client \
	connman-conf \
"

#no configuration
SFTP = " \
	openssh-sftp-server \
"

FTP = " \
	vsftpd \
"

# start cam : raspivid -t 0
#	vidserver
CAMERA = " \
	userland \
"

HELLOWORLD = " \
	hello-mod \
	helloworld \
"

MOTORS = " \
	a4988-mod \
"

#	i2c-tools
IMU = " \
	mpu9250-mod \
"

#lsb, gpsd
#	mtk3339d-test 
GPS = " \
	mtk3339d \
"

AUTOSCOPE = " \
	autoscope-test-mtk3339d \
"

IMAGE_INSTALL += " \
	${CAMERA} \
	${FTP} \
	${HOTSPOT} \
	${HELLOWORLD} \
	${IMU} \
	${GPS} \
	${AUTOSCOPE} \
"

#DISTRO_FEATURES += "wifi"
#MACHINE_FEATURES += "wifi"
#IMAGE_INSTALL_remove = " \
#	bluetooth \
#	bluez \
#"

#hotspot() {
#	echo 'net.ipv4.ip_forward = 1' >> ${IMAGE_ROOTFS}/etc/sysctl.conf
#}

#ROOTFS_POSTPROCESS_COMMAND += " hotspot; "
