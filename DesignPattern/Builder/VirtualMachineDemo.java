package DesignPattern.Builder;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 11:39
 */
public class VirtualMachineDemo {

    public static void main(String[] args) {
        VirtualMachine vm = new VirtualMachine.Builder("subid","rg",Region.ChinaEast,"myVm")
                .withStorage("storage").withOsDisk("osdisk").withNetWorkInterface("networkinterface").withOsType(OsType.Linux).build();
        System.out.println(vm);
    }
}
