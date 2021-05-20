package com.fillipelima.binarytree;

public class SerializeDeserialize {
	
	public static void main(String[] args) {

		SerializeDeserialize sd = new SerializeDeserialize();
		TreeNode node = sd.new TreeNode(1, sd.new TreeNode(2, null, null), sd.new TreeNode(3, sd.new TreeNode(4, null, null), sd.new TreeNode(5, null, null)));
		String data = sd.serialize(node);
		System.out.println(data);
		sd.deserialize(data);
	}

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) 
            return "nnnn";
        StringBuilder sb = new StringBuilder();
        sb.append(buildElement(root.val));
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));        	

        return sb.toString();
    }
    
    private String buildElement(int e) {
        int l = String.valueOf(e).length();
        StringBuilder sb = new StringBuilder();
        for (int i = l; i < 4; i++) {
            sb.append("0");    
        }
        sb.append(e);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String s = data.substring(0, 4);            
        if (s.equals("nnnn"))
            return null;

        TreeNode node = new TreeNode(new Integer(s));
        
        try {
            node.left = deserialize(data.substring(4));    
            node.right = deserialize(data.substring(4));
        }catch (Exception e) { 
        }
    
        return node;
    }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
