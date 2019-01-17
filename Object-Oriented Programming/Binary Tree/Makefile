# Usage: make -e EXECUTABLE=file
#
# The Unix-program "make" will generate an executable 
# with name "file" from an NASM assembler file "file.asm".
# Furthermore it will generate an annotated listing
# of the machine code in "file.lst".
# Moreover it will generate as much debugging information
# as possible.
#
# Note: The option "-e EXECUTABLE=file" means that the
# environment variable "EXECUTABLE" will be initialized with
# the string "file" and passed on to "make".
#
# Version to compile on 32bit Cygwin

all: $(EXECUTABLE).obj driver.c asm_io.obj

# The overall goal "all" depends on "file.o", "driver.c" and "asm_io.o".
# Given all three files the C-compiler gcc will generate the executable.

	gcc -o $(EXECUTABLE) -ggdb $(EXECUTABLE).obj driver.c asm_io.obj

# Explanation of the options:
# "-o $(EXECUTABLE)" defines the name of the executable
# "-ggdb" produces debugging information to be used by the
# GNU debugger gdb

asm_io.obj: asm_io.asm

# The object file "asm_io.o" depends on "asm_io.asm".
# The assembler nasm will assemble "asm_io.asm" if needed.
#nasm -f elf -d ELF_TYPE asm_io.asm

	nasm -f win asm_io.asm

# Explanation of the option:
# "-f elf" sets the format of the generated object code to the
# format "elf"
# "-d ELF_TYPE" defines the macro "ELF_TYPE" in the file "asm_io.asm"

$(EXECUTABLE).obj: $(EXECUTABLE).asm asm_io.inc

# The object file "file.o" depends on "file.asm" and the include file
# "asm_io.inc". The assembler nasm will assemble "file.asm" if needed.

#nasm -f elf -d ELF_TYPE -g -l $(EXECUTABLE).lst $(EXECUTABLE).asm

	nasm -f win -g -l $(EXECUTABLE).lst $(EXECUTABLE).asm

# Explanation of the option:
# "-f elf" sets the format of the generated object code to the
# format "elf"
# "-d ELF_TYPE" defines the macro "ELF_TYPE" in the assembler file
# "-g" adds debugging information to the generated object file
# "-l $(EXECUTABLE).lst" defines the name of the annotated listing
# of the machine code
