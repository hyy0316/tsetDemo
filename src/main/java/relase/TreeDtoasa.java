package relase;

import java.util.List;

/**
 * @author relaser
 *
 * @date 2021/1/4 9:47
 */
public class TreeDtoasa {
        private String name;
        private String t;
        private int id;
        private int pid;
        private boolean open;
        private boolean click;
        private boolean isParent;
        List<TreeDtoasa> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isClick() {
        return click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public List<TreeDtoasa> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDtoasa> children) {
        this.children = children;
    }


//    String text;
//    Boolean selectable;
//    TreeState state;
//    List<TreeDto> nodes;
//
//    public TreeState getState() {
//        return state;
//    }
//
//    public void setState(TreeState state) {
//        this.state = state;
//    }
//
//    public Boolean getSelectable() {
//        return selectable;
//    }
//
//    public void setSelectable(Boolean selectable) {
//        this.selectable = selectable;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public List<TreeDto> getNodes() {
//        return nodes;
//    }
//
//    public void setNodes(List<TreeDto> nodes) {
//        this.nodes = nodes;
//    }




}
