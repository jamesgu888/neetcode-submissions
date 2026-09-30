class Solution {
    // public int maxProfit(int[] prices) {
    //     int minHighest = 0, minCurrent = 0, minActual = 0;

    //     int i = 0, j = 0, priceToBuy = 0;
    //     while (i < prices.length) {
    //         priceToBuy = prices[i];
    //         j = i + 1;
    //         while(j < prices.length - 1) {
    //             minActual = prices[j] - prices[i];
    //             if(minActual > 0 && minActual > minCurrent) {
    //                 minCurrent = minActual;
    //             }
    //             j++;
    //         }

    //         if(minCurrent > minHighest) {
    //             minHighest = minCurrent;
    //         }
    //         i++;
    //     }

    //     return minHighest;
    // }


        public int maxProfit(int[] prices) {
        int minHighest = 0, minCurrent = 0, minActual = 0, priceToBuy = 0;

        for(int i = 0; i < prices.length; i++) {
            priceToBuy = prices[i];
            System.out.printf("i:%d\t priceToBuy: %d\n", i, priceToBuy);
            for(int j = i+1; j < prices.length; j++) {
                minActual = prices[j] - prices[i];
                System.out.printf("j:%d\t priceToSell: %d\t minActual: %d\t minCurrent: %d\n", j, prices[j], minActual, minCurrent);
                if(minActual > 0 && minActual > minCurrent) {
                    minCurrent = minActual;
                    System.out.printf("Updating minCurrent:%d\n", minCurrent);
                }
            }
            if(minCurrent > minHighest) {
                minHighest = minCurrent;
                System.out.printf("Updating minHighest:%d\n", minHighest);
            }            
        }

        return minHighest;
    }
}
