package physicsengine;

import java.awt.EventQueue;

public class Physics {

    private GUI gui; 
    private boolean running = true;

    public Physics(GUI gui) {
        this.gui = gui;
    }

    public void startSimulation() {
        new Thread(this::updateLoop).start();
    }

    private void updateLoop() {
        long lastUpdate = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            float deltaTime = (now - lastUpdate) / 1000000000.0f; 
            lastUpdate = now;

            System.out.println("Delta time: " + deltaTime);
            World manager = World.getInstance();
            for (Ball ball : manager.getBalls()) {
                ball.addForce(new Vector2(0, 9.8f * deltaTime));
                ball.update(deltaTime);
            }

            EventQueue.invokeLater(gui::repaint);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }

    public void stopSimulation() {
        running = false;
    }
}
