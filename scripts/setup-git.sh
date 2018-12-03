#!/bin/bash

cd $(echo $0 | sed s"/$(basename $0)//"g)/..

git checkout -B master origin/master && exit 0

exit 1
