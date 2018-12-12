#!/bin/bash

source /etc/profile

executor_home=$(cd "$(dirname "$0")"; pwd)/..

echo executor_home: ${executor_home}
cd ${executor_home}

mvn clean package -Dmaven.test.skip=true