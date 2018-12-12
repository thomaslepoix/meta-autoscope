SUMMARY = "Linux image"
DESCRIPTION = "Autoscope base OS"
LICENCE = "GPL"
#inherit autoscope

include recipes-core/images/core-image-minimal.bb

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
