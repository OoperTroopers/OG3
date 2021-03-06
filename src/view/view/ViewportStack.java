package view.view;

import java.util.ArrayList;

public class ViewportStack {
        
        private static ViewportStack viewportStack = new ViewportStack();
        private static ArrayList<Viewport> stack;
        
        public ViewportStack() {
            stack = new ArrayList<Viewport>();
	}
        
        public static boolean pop() {
            if (stack.isEmpty()) return false;
            stack.remove(stack.size() - 1);
            return true;
        }
        
        public static Viewport top() {
            if (stack.isEmpty()) {
            	System.out.println("is empty");
            	return null;
            }
            if (stack.get(stack.size()-1) == null) System.out.println("is null");
            return stack.get(stack.size() - 1);
        }
        
        public static boolean isEmpty() {
            return stack.isEmpty();
        }
        
        public static void add(Viewport v) {
        	System.out.println("adding viewport");
        	if (v == null) System.out.println("VIEWPORT IS NULL");
            stack.add(v);
            System.out.println("Stack size is "+stack.size());
        }
        
        public static int size() {
            return stack.size();
        }
        
        public static ViewportStack getInstance() {
            return viewportStack;
        }
        
	
//	private MainMenuViewport mainMenuViewport;
//	private ActiveGameViewport activeGameViewport;
//	private HeartsViewport heartsViewport;
//	private SimpleStatsViewport simpleStatsViewport;
//	private PauseMenuViewport pauseMenuViewport;
//        private ExtendedStatsViewport extendedStatsViewport;
//	
//	
//	
//	public void whichViewports() {
//		if (mainMenuViewport != null)  		System.out.println("Main Menu Viewport");
//		if (activeGameViewport != null)  	System.out.println("Active Game Viewport");
//		if (heartsViewport != null)  		System.out.println("Hearts Viewport");
//		if (simpleStatsViewport != null)  	System.out.println("Simple Stats Viewport");
//		if (pauseMenuViewport != null)  	System.out.println("Pause Menu Viewport");
//                if (extendedStatsViewport != null)  	System.out.println("Extended Stats Viewport");
//	}
//	
//	public static ViewportStack getInstance() {
//		return viewportStack;
//	}
//		
//	public void add(MainMenuViewport v) {		mainMenuViewport = v;           }
//	public void add(ActiveGameViewport v) {		activeGameViewport = v;         }
//	public void add(HeartsViewport v) {		heartsViewport = v;             }
//	public void add(SimpleStatsViewport v) {	simpleStatsViewport = v;        }
//	public void add(PauseMenuViewport v) {          pauseMenuViewport = v;          }
//        public void add(ExtendedStatsViewport v) {      extendedStatsViewport = v;      }
//	
//	
//	// the "pop"s return true if there was one originally
//	public boolean popMainMenuViewport() {			
//		if (mainMenuViewport != null) {
//			mainMenuViewport = null; 
//			return true;
//		}	return false;
//	}
//	
//	public boolean popActiveGameViewport() {
//		if (activeGameViewport != null) {
//			activeGameViewport = null; 
//			return true;
//		} 	return false;
//	}
//	
//	public boolean popHeartsViewport() {
//		if (heartsViewport != null) {
//			heartsViewport = null; 
//			return true;
//		} 	return false;
//	}
//	
//	public boolean popSimpleStatsViewport() {
//		if (simpleStatsViewport != null) {
//			simpleStatsViewport = null; 
//			return true;
//		} 	return false;
//	}
//	
//	public boolean popPauseMenuViewport() {
//		if (pauseMenuViewport != null) {
//			pauseMenuViewport = null; 
//			return true;
//		} 	return false;
//	}
//        
//        public boolean popExtendedStatsViewport() {
//            if (extendedStatsViewport != null) {
//		extendedStatsViewport = null; 
//		return true;
//            } 	
//            return false;
//	}
}
