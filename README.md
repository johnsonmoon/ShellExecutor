# Shell-Executor
shell command execution tool

## Introduction
An easy tool for executing shell command, with sub-process output message receive.

## Usage

Example like: 
```
@Test
public void simpleTest() {
    try {
        int exitValue = ShellExecutor.execute(
                "./test.sh",
                System.getProperty("user.dir")+"/scripts",
                null,
                (message, process) -> System.out.println(message)
        );
        System.out.println("exitValue: " + exitValue);
    } catch (ShellExecutor.CommandTimeoutException e) {
        System.out.println(e.getMessage());
    }
}
```

While the shell script **test.sh** like this:
```
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
```

And the result is: 
```
Printout success, index: 0
Printout success, index: 1
Printout success, index: 2
Printout success, index: 3
Printout success, index: 4
Printout success, index: 5
Printout success, index: 6
Printout success, index: 7
Printout success, index: 8
Printout success, index: 9
Printout success, index: 10
Printout success, index: 11
Printout success, index: 12
Printout success, index: 13
Printout success, index: 14
Printout success, index: 15
Printout success, index: 16
Printout success, index: 17
Printout success, index: 18
Printout success, index: 19
exitValue: 0
```

