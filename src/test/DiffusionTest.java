package test;

import implementation.DiffusionAtomique;
import implementation.DiffusionSequentielle;
import implementation.Main;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class DiffusionTest extends TestCase {




    /**
     * Verify condition for diffusion Atomique
     * @throws InterruptedException
     */
    @Test
    public void testDiffusionAtomique() throws Exception {
        System.out.println("----------------Diffusion atomique------------------");
        List<List<Integer>> result =Main.execDiffusion(new DiffusionAtomique());
        boolean allValues = true;
        Iterator<List<Integer>> it = result.iterator();

        while (it.hasNext()){
            List<Integer> current = it.next();
            Iterator<Integer> it1 = it.next().iterator();
            int count = 0;
            while (it1.hasNext()){
                int current1 = it1.next();
                if(current1 != count+1){
                    allValues = false;
                }
                count = current1;
            }
        }

        assertTrue(allValues);

    }

    /**
     * Verify condition for diffusionSequentielle
     * @throws InterruptedException
     */
    @Test
    public void testDiffusionSequentielle()throws InterruptedException{
        System.out.println("----------------Diffusion séquentielle------------------");
        List<List<Integer>> result =Main.execDiffusion(new DiffusionSequentielle());
        boolean equal = true;
        boolean increasing = true;
        Iterator<List<Integer>> it = result.iterator();

        while (it.hasNext()){
            List<Integer> current = it.next();
            Iterator<Integer> it1 = current.iterator();
            int count = 0;
            while (it1.hasNext()){
                int current1 = it1.next();
                if(current1 <= count){
                    increasing = false;
                }
                count = current1;
            }
            if (!current.equals(it.next())){
                equal = false;
            }
        }

        assertTrue(increasing && equal);
    }

}