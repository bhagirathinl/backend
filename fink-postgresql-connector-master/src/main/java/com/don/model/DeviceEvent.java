package com.don.model;

public class DeviceEvent {
    
	@Override
	public String toString() {
		return "DeviceEvent [eventId=" + eventId + ", collectionTime=" + collectionTime + ", abi=" + abi
				+ ", androidId=" + androidId + ", batteryStatus=" + batteryStatus + ", brand=" + brand + ", carrier="
				+ carrier + ", clntTime=" + clntTime + ", cores=" + cores + ", debugger=" + debugger + ", device="
				+ device + ", display=" + display + ", displayResolution=" + displayResolution + ", drmId=" + drmId
				+ ", dummy0=" + dummy0 + ", emulator=" + emulator + ", health=" + health + ", hook=" + hook
				+ ", isWifiOn=" + wifiOn + ", manufacturer=" + manufacturer + ", maxFreq=" + maxFreq + ", memscan="
				+ memscan + ", minFreq=" + minFreq + ", model=" + model + ", deviceId=" + deviceId + ", osVersion="
				+ osVersion + ", p2p0=" + p2p0 + ", plugged=" + plugged + ", product=" + product + ", r_rmnet_data0="
				+ r_rmnet_data0 + ", r_rmnet_data1=" + r_rmnet_data1 + ", rmnet_data0=" + rmnet_data0 + ", rmnet_data1="
				+ rmnet_data1 + ", rmnet_data2=" + rmnet_data2 + ", root=" + root + ", telEventTime=" + telEventTime
				+ ", telType=" + telType + ", totalMemory=" + totalMemory + ", tun0=" + tun0 + ", tun1=" + tun1
				+ ", txId=" + txId + ", venv=" + venv + ", wlan0=" + wlan0 + "]";
	}
	private String eventId;
    private String collectionTime;
    private String abi;
    private String androidId;
    private int batteryStatus;
    private String brand;
    private String carrier;
    private long clntTime;
    private int cores; 
    private boolean debugger;
    private String device;
    private String display;
    private String displayResolution;
    private String drmId;
    private String dummy0;
    private String emulator;
    private int health;
    private boolean hook;
    private boolean wifiOn;
    private String manufacturer;
    private int maxFreq;
    private boolean memscan;
    private int minFreq;
    private String model;
    private String deviceId;
    private int osVersion;
    private String p2p0;
    private int plugged;
    private String product;
    private String r_rmnet_data0;
    private String r_rmnet_data1;
    private String rmnet_data0;
    private String rmnet_data1;
    private String rmnet_data2;
    private String root;
    private String telEventTime;
    private String telType;
    private String totalMemory;
    private String tun0;
    private String tun1;
    private String txId;
    private String venv;
    private String wlan0;
    
    public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getCollectionTime() {
		return collectionTime;
	}
	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}
	public String getAbi() {
		return abi;
	}
	public void setAbi(String abi) {
		this.abi = abi;
	}
	public String getAndroidId() {
		return androidId;
	}
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}
	public int getBatteryStatus() {
		return batteryStatus;
	}
	public void setBatteryStatus(int batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public long getClntTime() {
		return clntTime;
	}
	public void setClntTime(long clntTime) {
		this.clntTime = clntTime;
	}
	public int getCores() {
		return cores;
	}
	public void setCores(int cores) {
		this.cores = cores;
	}
	public boolean isDebugger() {
		return debugger;
	}
	public void setDebugger(boolean debugger) {
		this.debugger = debugger;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getDisplayResolution() {
		return displayResolution;
	}
	public void setDisplayResolution(String displayResolution) {
		this.displayResolution = displayResolution;
	}
	public String getDrmId() {
		return drmId;
	}
	public void setDrmId(String drmId) {
		this.drmId = drmId;
	}
	public String getDummy0() {
		return dummy0;
	}
	public void setDummy0(String dummy0) {
		this.dummy0 = dummy0;
	}
	public String getEmulator() {
		return emulator;
	}
	public void setEmulator(String emulator) {
		this.emulator = emulator;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public boolean isHook() {
		return hook;
	}
	public void setHook(boolean hook) {
		this.hook = hook;
	}
	public boolean isWifiOn() {
		return wifiOn;
	}
	public void setWifiOn(boolean isWifiOn) {
		this.wifiOn = isWifiOn;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getMaxFreq() {
		return maxFreq;
	}
	public void setMaxFreq(int maxFreq) {
		this.maxFreq = maxFreq;
	}
	public boolean isMemscan() {
		return memscan;
	}
	public void setMemscan(boolean memscan) {
		this.memscan = memscan;
	}
	public int getMinFreq() {
		return minFreq;
	}
	public void setMinFreq(int minFreq) {
		this.minFreq = minFreq;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(int osVersion) {
		this.osVersion = osVersion;
	}
	public String getP2p0() {
		return p2p0;
	}
	public void setP2p0(String p2p0) {
		this.p2p0 = p2p0;
	}
	public int getPlugged() {
		return plugged;
	}
	public void setPlugged(int plugged) {
		this.plugged = plugged;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getR_rmnet_data0() {
		return r_rmnet_data0;
	}
	public void setR_rmnet_data0(String r_rmnet_data0) {
		this.r_rmnet_data0 = r_rmnet_data0;
	}
	public String getR_rmnet_data1() {
		return r_rmnet_data1;
	}
	public void setR_rmnet_data1(String r_rmnet_data1) {
		this.r_rmnet_data1 = r_rmnet_data1;
	}
	public String getRmnet_data0() {
		return rmnet_data0;
	}
	public void setRmnet_data0(String rmnet_data0) {
		this.rmnet_data0 = rmnet_data0;
	}
	public String getRmnet_data1() {
		return rmnet_data1;
	}
	public void setRmnet_data1(String rmnet_data1) {
		this.rmnet_data1 = rmnet_data1;
	}
	public String getRmnet_data2() {
		return rmnet_data2;
	}
	public void setRmnet_data2(String rmnet_data2) {
		this.rmnet_data2 = rmnet_data2;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getTelEventTime() {
		return telEventTime;
	}
	public void setTelEventTime(String telEventTime) {
		this.telEventTime = telEventTime;
	}
	public String getTelType() {
		return telType;
	}
	public void setTelType(String telType) {
		this.telType = telType;
	}
	public String getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(String totalMemory) {
		this.totalMemory = totalMemory;
	}
	public String getTun0() {
		return tun0;
	}
	public void setTun0(String tun0) {
		this.tun0 = tun0;
	}
	public String getTun1() {
		return tun1;
	}
	public void setTun1(String tun1) {
		this.tun1 = tun1;
	}
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getVenv() {
		return venv;
	}
	public void setVenv(String venv) {
		this.venv = venv;
	}
	public String getWlan0() {
		return wlan0;
	}
	public void setWlan0(String wlan0) {
		this.wlan0 = wlan0;
	}

    // Getters and Setters (can be generated using your IDE or Lombok if preferred)

    // Optional: toString(), equals(), hashCode()
}