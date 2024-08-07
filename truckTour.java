public static int truckTour(List<List<Integer>> petrolpumps) {
    int start = 0;
    int totalPetrol = 0;
    int currentPetrol = 0;

    for (int i = 0; i < petrolpumps.size(); i++) {
        int petrol = petrolpumps.get(i).get(0);
        int distance = petrolpumps.get(i).get(1);
        
        totalPetrol += petrol - distance;
        currentPetrol += petrol - distance;
        
        if (currentPetrol < 0) {
            start = i + 1;
            currentPetrol = 0;
        }
    }

    return totalPetrol >= 0 ? start : -1;
}
