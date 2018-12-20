SUMMARY = "Linux image"
DESCRIPTION = "Autoscope base OS"
LICENCE = "GPL"
export IMAGE_BASENAME = "autoscope-console-image"

inherit core-image

IMAGE_FEATURES += "ssh-server-dropbear splash"
#SPLASH = "psplash-raspberrypi"

inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P estei root; "

CORE = " \
	kernel-modules \
	"

CONNECTIVITY = " \
	linux-firmware \
	i2c-tools \
	python-smbus \
	bridge-utils \
	hostapd \
	iptables \
	wpa-supplicant \
"

#start cam : raspivid -t 0
CAMERA = " \
	userland \
"

#DISTRO_FEATURES += "wifi"
#MACHINE_FEATURES += "wifi"

IMAGE_INSTALL += " \
	${CONNECTIVITY} \
	${CAMERA} \
"
