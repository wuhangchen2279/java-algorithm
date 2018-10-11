public class Neighbour {
    public String homeOwnerName;
    public int houseNumber;

    public Neighbour next;
    public Neighbour previous;

    public Neighbour(String homeOwnerName, int houseNumber) {
        this.homeOwnerName = homeOwnerName;
        this.houseNumber = houseNumber;
    }

    public void display() {
        System.out.println(this.homeOwnerName + ": " + this.houseNumber);
    }

    public String toString() {
        return homeOwnerName;
    }
}

class DoubleEndedLinkedList {
    Neighbour firstLink;
    Neighbour lastLink;

    public void insertInFirstPosition(String homeOwnerName, int houseNumber) {
        Neighbour newNeighbour = new Neighbour(homeOwnerName, houseNumber);
        
        if(isEmpty()) {
            lastLink = newNeighbour;
        } else {
            firstLink.previous = newNeighbour; //doubly link
        }
        newNeighbour.next = firstLink;
        firstLink = newNeighbour;
    }

    public void insertInLastPosition(String homeOwnerName, int houseNumber) {
        Neighbour newNeighbour = new Neighbour(homeOwnerName, houseNumber);

        if(isEmpty()) {
            firstLink = newNeighbour;
        } else {
            lastLink.next = newNeighbour;
            newNeighbour.previous = lastLink; //double linked list
        }
        lastLink = newNeighbour;

    }

    public boolean insertAfterKey(String homeOnwerName, int houseNumber, int key) {
        Neighbour newNeighbour = new Neighbour(homeOnwerName, houseNumber);
        Neighbour currentNeighbour = firstLink;

        while(currentNeighbour.houseNumber != key) {
            currentNeighbour = currentNeighbour.next;
            if(currentNeighbour == null) {
                return false;
            }
        }

        if(currentNeighbour == lastLink) {
            newNeighbour.next = null;
            lastLink = newNeighbour;
        } else {
            newNeighbour.next = currentNeighbour.next;
            currentNeighbour.next.previous = newNeighbour;
        }

        newNeighbour.previous = currentNeighbour;
        currentNeighbour.next = newNeighbour;
        return true;

    }

    public void insertInOrder(String homeOnwerName, int houseNumber) {
        Neighbour newNeighbour = new Neighbour(homeOnwerName, houseNumber);

        Neighbour previousNeighbour = null;
        Neighbour currentNeighbour = firstLink;

        while(currentNeighbour != null && (houseNumber > currentNeighbour.houseNumber)) {
            previousNeighbour = currentNeighbour;
            currentNeighbour = currentNeighbour.next;
        }

        if(previousNeighbour == null) {
            firstLink = newNeighbour;
        } else {
            previousNeighbour.next = newNeighbour;
        }

        newNeighbour.next = currentNeighbour;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public static void main(String args[]) {
        DoubleEndedLinkedList theLinkedLIst = new DoubleEndedLinkedList();
        theLinkedLIst.insertInOrder("Mark", 7);
        theLinkedLIst.insertInOrder("Daniel", 9);
        theLinkedLIst.insertInOrder("Noel", 6);
        theLinkedLIst.insertInOrder("Mary", 4);

        theLinkedLIst.display();
    }

    public void display() {
        Neighbour theLink = firstLink;

        while(theLink != null) {
            theLink.display();
            System.out.println("Next link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }
}

class NeighbourIterator{
    Neighbour currentNeighbour;
    Neighbour previousNeighbour;

    DoubleEndedLinkedList theNeighbours;

    public NeighbourIterator(DoubleEndedLinkedList theNeighbours) {
        this.theNeighbours = theNeighbours;
        currentNeighbour = theNeighbours.firstLink;
        previousNeighbour = theNeighbours.lastLink;
    }

    public boolean hasNext() {
        if(currentNeighbour.next != null) {
            return true;
        }
        return false;
    }

    public Neighbour next() {
        if(hasNext()) {
            previousNeighbour = currentNeighbour;
            currentNeighbour = currentNeighbour.next;
            return currentNeighbour;
        }
        return null;
    }

    public void remove() {
        if(previousNeighbour == null) {
            theNeighbours.firstLink = currentNeighbour.next;
        } else {
            previousNeighbour.next = currentNeighbour.next;
            if(currentNeighbour.next == null) {
                currentNeighbour = theNeighbours.firstLink;
                previousNeighbour =null;
            } else {
                currentNeighbour = currentNeighbour.next;
            }
        }
    }
}