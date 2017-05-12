package Handlers;

import java.util.ArrayList;

public class StoryNode {
	private ArrayList<StoryNode> subNodes = new ArrayList<StoryNode>();
	private ArrayList<StoryNode> superNodes = new ArrayList<StoryNode>();

	public StoryNode() {
		// Instantiate an empty node.
	}

	public StoryNode(StoryNode superNode) {
		superNodes.add(superNode);
	}

	public StoryNode(StoryNode... superNodes) {
		// implement varargs constructor
	}

	public void run() {
		// Override this when instantiating object.
	}

	public StoryNode addSubNode() {
		StoryNode subNode = new StoryNode();
		return addSubNode(subNode);
	}

	public StoryNode addSubNode(StoryNode subNode) {
		subNodes.add(subNode);
		subNode.addSuperNode(this);
		return subNode;
	}

	public StoryNode addSuperNode() {
		StoryNode superNode = new StoryNode();
		return addSuperNode(superNode);
	}

	public StoryNode addSuperNode(StoryNode superNode) {
		superNodes.add(superNode);
		superNode.addSubNode(this);
		return superNode;
	}

	public StoryNode getSubNode() {
		return getSubNode(0);
	}

	public StoryNode getSubNode(int i) {
		return subNodes.get(i);
	}

	public StoryNode getSuperNode() {
		return getSuperNode(0);
	}

	public StoryNode getSuperNode(int i) {
		return superNodes.get(i);
	}

	// method to return ancestors
}