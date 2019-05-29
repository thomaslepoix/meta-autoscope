SUMMARY = "Linux image"
DESCRIPTION = "Autoscope base OS"
LICENCE = "GPL"
export IMAGE_BASENAME = "autoscope-console-image"

inherit core-image

#SPLASH = "psplash-raspberrypi"
#IMAGE_FEATURES += "ssh-server-dropbear splash"
IMAGE_FEATURES += "ssh-server-openssh splash"

# user autoscope    : FTP only
# user admin        : SSH only
# user root         : local only
inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P estei root; \
	useradd -P estei autoscope; \
	useradd -P estei admin; "

HOTSPOT = " \
	iptables \
	connman \
	connman-client \
	connman-conf \
"

# no configuration
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

# lsb, gpsd
#	mtk3339d-test 
GPS = " \
	mtk3339d \
"

#	autoscope-test-a4988
TESTS = " \
	autoscope-test-mtk3339d \
"

AUTOSCOPE_CORE = " \
"

IMAGE_INSTALL += " \
	${CAMERA} \
	${FTP} \
	${HOTSPOT} \
	${HELLOWORLD} \
	${IMU} \
	${GPS} \
	${TESTS} \
"

#hotspot() {
#	echo 'net.ipv4.ip_forward = 1' >> ${IMAGE_ROOTFS}/etc/sysctl.conf
#}

#ROOTFS_POSTPROCESS_COMMAND += " hotspot; "
