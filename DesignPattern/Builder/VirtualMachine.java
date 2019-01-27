package DesignPattern.Builder;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 11:10
 */
public final class VirtualMachine {

    private final String subscriptionId;
    private final String resourceGroup;
    private final Region region;
    private final String name;

    private final String osDisk;
    private final String storage;
    private final OsType osType;
    private final String networkInterface;

    private VirtualMachine(Builder builder)
    {
        this.subscriptionId = builder.subscriptionId;
        this.resourceGroup = builder.resourceGroup;
        this.region = builder.region;
        this.name = builder.name;
        this.osDisk = builder.osDisk;
        this.storage = builder.storage;
        this.osType = builder.osType;
        this.networkInterface = builder.networkInterface;
    }

    @Override
    public String toString() {
        return String.format("/subcriptionid/%s/region/%s/resourcegroup/%s/name/%s", subscriptionId, region, resourceGroup, name);
    }

    public static class Builder
    {
        private final String subscriptionId;
        private final String resourceGroup;
        private final Region region;
        private final String name;

        private  String osDisk;
        private  String storage;
        private  OsType osType;
        private  String networkInterface;
        public Builder(String subscriptionId, String resourceGroup, Region region, String name)
        {
            this.subscriptionId = subscriptionId;
            this.resourceGroup = resourceGroup;
            this.region = region;
            this.name = name;
        }

        public Builder withOsDisk(String osDisk)
        {
            this.osDisk = osDisk;
            return this;
        }

        public Builder withStorage(String storage)
        {
            this.storage =  storage;
            return this;
        }

        public Builder withOsType(OsType osType)
        {
            this.osType = osType;
            return this;
        }
        public Builder withNetWorkInterface(String netWorkInterface)
        {
            this.networkInterface = netWorkInterface;
            return this;
        }
        public VirtualMachine build()
        {
            return new VirtualMachine(this);
        }
    }

}
