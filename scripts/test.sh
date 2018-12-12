#!/bin/bash

source /etc/profile

i=0
while((${i} < 20))
do
    echo "Printout success, index: ${i}"
    let "i++"
    sleep 2
done

exit 0