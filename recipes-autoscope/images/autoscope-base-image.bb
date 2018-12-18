SUMMARY = "Linux image"
DESCRIPTION = "Autoscope base OS"
LICENCE = "GPL"
#inherit autoscope

include recipes-core/images/core-image-minimal.bb

### RPI-BASIC-IMAGE
# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
	"

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-dropbear splash"
###################

inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P autoscope root; "

CONNECTIVITY = " \
	linux-firmware \
	i2c-tools \
	python-smbus \
	bridge-utils \
	hostapd \
	iptables \
	wpa-supplicant \
"

DISTRO_FEATURES += "wifi"
MACHINE_FEATURES += "wifi"
IMAGE_INSTALL += " \
	${CONNECTIVITY} \
"

INSTALL_append += " rpi-config"
