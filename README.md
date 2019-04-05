# meta-autoscope

## Description

Yocto layer for an automated telescope based on Raspberry-Pi 3.

More informations about this project on the main repository [https://github.com/thibaudledo/Autoscope]

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

<br>

## Usage

Download sources :

```
~ $
    mkdir yocto-autoscope
    cd yocto-autoscope
    repo init -u https://github.com/thomaslepoix/meta-autoscope -b rpi-repo
    repo sync
```

Work on this repository :

```
~/yocto-autoscope/ $
    cd sources/meta-autoscope
    git checkout rpi
```

Build image :

```
~/yocto-autoscope/ $
    TEMPLATECONF="../meta-autoscope/conf"
    source sources/poky/oe-init-build-env rpi-build/ 
    bitbake autoscope-console-image
```


