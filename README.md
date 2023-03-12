

## rars模拟器指令调用的入口

`src/rars/simulator/Simulator.java`

`run()`方法模拟了指令的执行，其中大部分是异常的处理和Debug的支持，模拟的核心调用是`instruction.simulate(statement)`	

## 添加指令方式

rars 的所有指令都定义在`src/rars/riscv/instructions`目录下面，每一条指令对应一个java文件，指令按照 RISC-V 的指令类型分为7类，定义在BasicInstructionFormat.java下。可以把需要扩展的指令分一个新的类，这里我暂时用`EXTEND`表示

```java
public enum BasicInstructionFormat {
    R_FORMAT, // 3 register instructions
    R4_FORMAT,// 4 registers instructions
    I_FORMAT, // 1 dst and 1 src register + small immediate
    S_FORMAT, // 2 src registers + small immediate
    B_FORMAT, // 2 src registers + small immediate shifted left
    U_FORMAT, // 1 dst register  + large immediate
    J_FORMAT,  // 1 dst register  + large immediate for jumping
    EXTEND  // for Digital Logic Design course isa extension
}
```

所有的指令都继承`BasicInstruction`这个基类，基类中定义了指令名字，指令类型，以及指令掩码。

```java
private String instructionName;
private BasicInstructionFormat instructionFormat;
private String operationMask;
private int opcodeMask; 
private int opcodeMatch;
```

添加指令需要创建一个继承`BasicInstruction`的类，按照新指令的掩码来写构造函数，同时重写方法`simulate()`，该方法内部具体定义了新指令的操作，这里添加的测试指令` src/rars/riscv/instructions/ISA_TEST.java `是对`RegisterFile`进行的操作，存储访问的指令需要做一些修改。

## 模拟器编译方式

模拟器的运行需要java8以上的环境支持，命令行执行`java -jar rars.jar`运行模拟器，运行脚本`./build-jar.sh`就可以编译得到`rars.jar`，
