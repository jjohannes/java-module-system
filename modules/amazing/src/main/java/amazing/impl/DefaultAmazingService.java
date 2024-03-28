package amazing.impl;

import amazing.AmazingService;

public class DefaultAmazingService implements AmazingService {
    @Override
    public void compute() {
        System.out.println("Hello from module " + getClass().getModule().getName());
    }
}
