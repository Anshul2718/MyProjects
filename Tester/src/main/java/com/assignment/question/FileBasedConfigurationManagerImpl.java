package main.java.com.assignment.question;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
    private static FileBasedConfigurationManagerImpl fileBasedConfigurationManagerImpl = null;
    private FileBasedConfigurationManagerImpl(){
        super();
    }

    public static FileBasedConfigurationManager getInstance(){
        // TODO Auto-generated method stub
        if(fileBasedConfigurationManagerImpl == null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if(fileBasedConfigurationManagerImpl == null){
                    fileBasedConfigurationManagerImpl = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return fileBasedConfigurationManagerImpl;
    }

    public static void resetInstance(){
        // TODO Auto-generated method stub
        fileBasedConfigurationManagerImpl = null;
    }

    @Override
    public String getConfiguration(String key){
        // TODO Auto-generated method stub
        return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        String value = properties.getProperty(key);
        if (value != null){
            return convert(value, type);
        }
        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        if(value != null){
            properties.setProperty(key, value.toString());
        }else{
            removeConfiguration(key);
        }
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        properties.remove(key);
    }

    public void clear(){
        // TODO Auto-generated method stub
        properties.clear();
    }
}
