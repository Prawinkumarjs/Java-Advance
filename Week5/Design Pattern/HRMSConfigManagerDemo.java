class HRMSConfigManager
{
    private static HRMSConfigManager instance;

    private HRMSConfigManager()
    {
        System.out.println("HRMS Configuration Manager Created");
    }

    public static HRMSConfigManager getInstance()
    {
        if (instance == null)
        {
            instance = new HRMSConfigManager();
        }

        return instance;
    }

    public void showCompanyName()
    {
        System.out.println("Company Name : HRMS Solutions");
    }

    public void showDatabaseName()
    {
        System.out.println("Database Name : HRMS Database");
    }

    public void showVersion()
    {
        System.out.println("Version : 1.0");
    }
}

public class HRMSConfigManagerDemo
{
    public static void main(String[] args)
    {
        HRMSConfigManager manager1 = HRMSConfigManager.getInstance();
        HRMSConfigManager manager2 = HRMSConfigManager.getInstance();
        HRMSConfigManager manager3 = HRMSConfigManager.getInstance();

        manager1.showCompanyName();
        manager1.showDatabaseName();
        manager1.showVersion();

        System.out.println("Same Object 1 and 2 : " + (manager1 == manager2));
        System.out.println("Same Object 2 and 3 : " + (manager2 == manager3));
        System.out.println("Same Object 1 and 3 : " + (manager1 == manager3));
    }
}