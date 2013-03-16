package com.chopnix.ircbot;

public class MemoryUsage {
  public static void printUsage(Runtime runtime) {
    long total, free, used;

    total = runtime.totalMemory();
    free  = runtime.freeMemory();
    used = total - free;

    System.out.println("\nTotal Memory: " + total);
    System.out.println("        Used: " + used);
    System.out.println("        Free: " + free);
    System.out.println("Percent Used: " + ((double)used/(double)total)*100);
    System.out.println("Percent Free: " + ((double)free/(double)total)*100);
  }

  public static final void main(String[] args) {
    Runtime runtime;
    // Print initial memory usage.
    runtime = Runtime.getRuntime();
    printUsage(runtime);

    printUsage(runtime);

    // Invoke garbage collector to reclaim the allocated memory.
    runtime.gc();

    // Wait 5 seconds to give garbage collector a chance to run
    try {
      Thread.sleep(5000);
    } catch(InterruptedException e) {
      e.printStackTrace();
      return;
    }

    printUsage(runtime);
  }
}