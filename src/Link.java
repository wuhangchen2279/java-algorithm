public class Link {

    public String bookName;
    public int milllionsSold;

    public Link next;

    public Link(String bookName, int milllionsSold) {
        this.bookName = bookName;
        this.milllionsSold = milllionsSold;
    }

    public void display() {
        System.out.println(bookName + ": " + milllionsSold + ",000,000");
    }

    public String toString() {
        return bookName;
    }
    
    public static void main(String args[]) {
        LinkList theLinkList = new LinkList();
        theLinkList.insertFirstLink("bookName1", 1);
        theLinkList.insertFirstLink("bookName2", 2);
        theLinkList.insertFirstLink("bookName3", 3);
        theLinkList.insertFirstLink("bookName4", 3);
        theLinkList.display();

        theLinkList.removeFirst();
        System.out.println(theLinkList.find("bookName3") + " was found");
        theLinkList.removeLink("bookName3");
        theLinkList.display();
    }
}

class LinkList{
    public Link firstLink;
    
    LinkList() {
        firstLink = null;
    }

    public boolean isEmpty() {
        return firstLink == null; 
    }

    public void insertFirstLink(String bookName, int milllionsSold) {
        Link newLink = new Link(bookName, milllionsSold);

        newLink.next = firstLink;

        firstLink = newLink;
    }

    public Link removeFirst() {
        Link linkRef = firstLink;
        if(!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty linklist");
        }
        return linkRef;
    }

    public void display() {
        Link theLink = firstLink;
        while(theLink != null) {
            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link find(String bookName) {
        Link theLink = firstLink;
        if(theLink != null) {
            while(theLink.bookName != bookName) {
                if(theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty linklist");
        }
        return theLink;
    }

    public Link removeLink(String bookName) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while(currentLink.bookName != bookName) {
            if(currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if(currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }

        return currentLink;
    }
}