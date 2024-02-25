package physicsengine;

import java.awt.EventQueue;

public class Physics {

    private GUI gui; 
    private boolean running = true;
    World world;
    
    public Physics(GUI gui) {
        this.gui = gui;
        world = World.getInstance();
    }

    public void startSimulation() {
        new Thread(this::updateLoop).start();
    }

    private void updateBalls(float deltaTime) {
        World world = World.getInstance(); 

        for (Ball ball : world.getBalls()) {

                Vector2 position = ball.getPosition();
                Vector2 velocity = ball.getVelocity();
                float radius = ball.getRadius();

                if (velocity.getX() <= 0.000000001f && velocity.getX() >= -0.000000001f && velocity.getY() <= 0.3 && !ball.isGrounded()) {
                    ball.setGrounded(true);
                    velocity = Vector2.ZERO();
                }

                //wall collision       (will overhaul with proper collisions)
                if (position.getX() > world.getWalls() - radius || position.getX() < radius) {
                    velocity.setX(-velocity.getX() * 0.5f);
                    position.setX(position.getX() > world.getWalls() - radius ? world.getWalls() - radius : radius);
                }

                //ground collision     (will overhaul with proper collisions)
                if (position.getY() > world.getGround() - radius || position.getY() < radius) {
                    velocity.setY(-velocity.getY() * 0.5f);
                    velocity.setX(velocity.getX() * 0.8f); //skidding effect?
                    position.setY(position.getY() > world.getGround() - radius ? world.getGround() - radius : radius);
                }

                Vector2 acc = new Vector2(ball.getAcceleration());
                acc.scale(deltaTime);
                velocity.add(acc);

                Vector2 vel = new Vector2(velocity);
                vel.scale(deltaTime);
                position.add(vel);

                ball.setPosition(position);
                ball.setVelocity(velocity);
                
                System.out.println("Vel: " + ball.getVelocity().toString());
                System.out.println("Acc: " + ball.getAcceleration().toString());
        }
    }
    private void updateLoop() {
        final long targetDelta = 1000000000 / 60; // Target time step in nanoseconds for 60 updates per second
        long lastTime = System.nanoTime();
        long accumulator = 0L;

        while (running) {
            long now = System.nanoTime();
            long elapsed = now - lastTime;
            lastTime = now;
            accumulator += elapsed;

            //update physics at a fixed time step
            while (accumulator >= targetDelta) {
                updateBalls(targetDelta / 1000000000.0f); 
                accumulator -= targetDelta;
            }

            EventQueue.invokeLater(gui::repaint);

            try {
                Thread.sleep(1); //reduce cpu usage
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopSimulation() {
        running = false;
    }
    
    public void implementForce(Body body, float deltaTime) {
    	
    }
}
