package basic;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getPetType(){
            return this.type;
        }
    }

    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }
    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnter{
        private Pet pet;
        private long count;

        public PetEnter(Pet pet,long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }
        public long getCount(){
            return this.count;
        }

    }

    public static class DCQueue{
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;

        private long count;

        public DCQueue(){
            this.dogQ = new LinkedList<PetEnter>();
            this.catQ = new LinkedList<PetEnter>();
        }
        //add
        public void add(Pet pet){
            if(pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnter(pet, this.count++));
            }
            else if(pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnter(pet, this.count++));
            }else{
                throw new RuntimeException("err,either dog or cat");
            }
        }

        //pollAll
        public Pet pollAll(){
            if(!this.dogQ.isEmpty()&&!this.catQ.isEmpty()){
                if(this.dogQ.peek().count< this.catQ.peek().count){
                    return this.dogQ.poll().getPet();
                }else
                    return this.catQ.poll().getPet();
            }
            else if(!this.dogQ.isEmpty())
                return this.dogQ.poll().getPet();
            else if(!this.catQ.isEmpty())
                return this.catQ.poll().getPet();
            else{
                throw new RuntimeException("err,queue is empty");
            }
        }

        //pollDog
        public Pet pollDog(){
            if(!this.dogQ.isEmpty()){
                return (Dog)this.dogQ.poll().getPet();
            }else
                throw new RuntimeException("dogQueue is empty");
        }
        //pollDog
        public Pet pollCat(){
            if(!this.catQ.isEmpty()){
                return (Cat)this.catQ.poll().getPet();
            }else
                throw new RuntimeException("dogQueue is empty");
        }

        public boolean isEmpty(){
            return this.dogQ.isEmpty()&&this.catQ.isEmpty();
        }
        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }
    }
}
