
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        int pX = 0;
        int pY = 0;
        int dX = -1;
        int dY = -1;
        getParentAndDepth(root,x,y,0,dX,dY,pX,pY);
        return ((dX == dY) && (pX != pY));
    }
    void getParentAndDepth(TreeNode* root, int x, int y, int d, int& dX , int& dY, int& pX, int& pY){
        if(!root) return;
        if(root->left){
            if(root->left->val == x){
                pX = root->val;
                dX= d+1;
            } else if(root->left->val == y){
                pY = root->val;
                dY = d+1;
            }
        }
        if(root->right){
            if(root->right->val == x){
                pX = root->val;
                dX= d+1;
            } else if(root->right->val == y){
                pY = root->val;
                dY = d+1;
            }
        }
        if(dX != -1 && dY != -1) return;
        getParentAndDepth(root->left,x,y,d+1,dX,dY,pX,pY);
        getParentAndDepth(root->right,x,y,d+1,dX,dY,pX,pY);
        
    }
};