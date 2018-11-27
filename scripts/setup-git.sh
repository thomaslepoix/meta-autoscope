#!/bin/bash

cd $(echo $0 | sed s"/$(basename $0)//"g)

echo "\
[core]
	repositoryformatversion = 0
	filemode = true
	bare = false
	logallrefupdates = true
[remote \"origin\"]
	url = https://github.com/thomaslepoix/meta-autoscope
	fetch = +refs/heads/*:refs/remotes/origin/*
[branch \"master\"]
	remote = origin
	merge = refs/heads/master" > ../.git/config && exit 0

exit 1
