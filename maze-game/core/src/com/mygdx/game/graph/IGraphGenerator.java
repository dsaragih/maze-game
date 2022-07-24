package com.mygdx.game.graph;

/**
 * Represents a graph generator
 * @author Ethan
 * @author Jack
 */
public interface IGraphGenerator {
    /**
     * Generate a planar graph
     * @return planar graph
     */
    public PlanarGraph generate();
}
