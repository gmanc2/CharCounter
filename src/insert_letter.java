import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
public class insert_letter
{
    public static void main(String[] args)
    {
        name_list data=new name_list();
        data.readname();
        data.printname();
        data.insert();
        data.printname();
        data.countCharacters();
        data.printCharsAndPos();
        System.exit(0);
    }
}

class name_list extends letter_node
{
    String value;
    letter_node first,current,current1,previous,next,save1,save2;

    int characterCount;
    int middleInitialPos;
    name_list()
    {
        //create a dummy first link
        first = new letter_node();
        first.next=null;
        previous=first;
    }

    void readname()
    {
        String value,output;
        char letterin;
        output="Enter name one letter at a time"+"\n"+"with a dash in between first and last name"+"\n"+
                "An * will stop input"+"\n"+"Please Enter a letter:";
        value =JOptionPane.showInputDialog(null,
                output,"Input Data",JOptionPane.QUESTION_MESSAGE);
        letterin=value.charAt(0);
        while(letterin!='*')
        {
            current=new letter_node();
            current.letter=letterin;
            current.next=null;
            previous.next=current;
            previous=current;
            value =JOptionPane.showInputDialog(null,
                    output,"Input Data",JOptionPane.QUESTION_MESSAGE);
            letterin=value.charAt(0);
        }
    }


    void printname()
    {
        current=first.next;
        System.out.println("NAME:");
        while(current!=null)
        {
            System.out.print(current.letter+" ");
            current=current.next;
        }
        System.out.println();
    }

    void insert()
    {
        char initial;
        value =JOptionPane.showInputDialog(null,
                "Enter the middle initial","Input Data",JOptionPane.QUESTION_MESSAGE);
        initial=value.charAt(0);

        //find the dash
        current=first.next;
        while(current!=null)
        {
            if(current.letter=='-')
            {
                save1=current;
                save2=current.next;
            }
            current=current.next;
        }
        current=new letter_node();
        current.letter=initial;
        current1=new letter_node();
        current1.letter='-';

        //set pointers
        save1.next=current;
        current.next=current1;
        current1.next=save2;

    }
    void countCharacters() {
        characterCount = 0;
        middleInitialPos = 0;
        int position = 0;
        boolean dash = false;
        boolean middleInital = false;

        current = first.next;
        while (current != null) {
            characterCount++;
            position++;
            if (current.letter == '-') {
                dash = true;
            } else if (dash && !middleInital) {
                middleInitialPos = position;
                middleInital = true;
            }
            current = current.next;
        }
    }
    void printCharsAndPos() {
        System.out.println("Total number of characters: " + characterCount);
        System.out.println("Position of middle initial: " + middleInitialPos);
    }
}
class letter_node
{
    char letter;
    letter_node next;
}
