package w3.w3_4_garbagecollector;

public class ResourceHolder {
    private final int resourceId;

    public ResourceHolder(int resourceId) {
        this.resourceId = resourceId;
    }

    // Finalizer for resource cleanup
    @Override
    protected void finalize() throws Throwable {
        try {
            // Release or cleanup logic
            System.out.println("Finalizing ResourceHolder with resourceId: " + resourceId);
        } finally {
            super.finalize();
        }
    }
}