# meta-autoscope

<br>

## Usage

Download sources :

```
mkdir yocto-autoscope
cd yocto-autoscope
repo init -u https://github.com/thomaslepoix/meta-autoscope -b repo
repo sync
```

Build image :

```
source setup-environnement autoscope-build/ 
bitbake base-image
```
