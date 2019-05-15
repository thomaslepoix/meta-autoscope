# meta-autoscope

Yocto layer for an automated telescope based on Raspberry-Pi 3.

More informations about this project on the main repository :

- https://github.com/thibaudledo/Autoscope

<br>

## Usage

Install dependencies :

```
~ $
    sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
    build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
    xz-utils debianutils iputils-ping libsdl1.2-dev xterm repo
```

Download sources :

```
~ $
    mkdir yocto-autoscope
    cd yocto-autoscope
    repo init -u https://github.com/thomaslepoix/meta-autoscope -b rpi-repo
    repo sync
```

Build image :

```
~/yocto-autoscope/ $
    TEMPLATECONF="../meta-autoscope/conf"
    source sources/poky/oe-init-build-env rpi-build/ 
    bitbake autoscope-console-image
```

Deploy image : 
```
~/yocto-autoscope/rpi-build/tmp/deploy/images/raspberrypi3/ $
    umount /dev/mmcblk0*
    sudo dd if="autoscope-console-image-raspberrypi3.rpi-sdimg" of="/dev/mmcblk0" status=progress
```

Work on this repository :

```
~/yocto-autoscope/ $
    cd sources/meta-autoscope
    git checkout rpi
```

Work on a driver (example hello-mod) :
```bash
~/yocto-autoscope/ $
    cd sources/meta-autoscope/recipes-test/hello-mod
    git clone https://github.com/thibaudledo/Autoscope -b hello_mod files

#IN meta-autoscope/recipes-test/hello-mod/hello-mod_git.bb
    #COMMENT
        SRC_URI = "git://github.com/thibaudledo/Autoscope;protocol=git;branch=hello_mod"
    #UNCOMMENT
        SRC_URI = "file://Makefile \
                   file://hello.c \
                   file://COPYING \
                  "

#IN meta-autoscope/recipes-autoscope/images/autoscope-console-image.bb
    IMAGE_INSTALL = " \
        hello-mod \
    "
```

<br>

## Dependencies

This layer depends on:

* URI: https://git.yoctoproject.org/git/poky
  * branch: sumo
  * revision: HEAD
  * revision: HEAD

* URI: https://git.openembedded.org/meta-openembedded
  * layers: meta-oe, meta-networking, meta-python
  * branch: sumo
  * revision: HEAD

* URI: https://github.com/agherzan/meta-raspberrypi
  * branch: sumo
  * revision: HEAD

* URI: https://github.com/meta-qt5/meta-qt5
  * branch: sumo
  * revision: HEAD

