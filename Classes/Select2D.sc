// crossfade between objects in a two-dimensional space
// dkg 2012
//
Select2D {

    *new {|rate, select, array|
        var selector = UGen.methodSelectorForRate(rate);
        var size = max(1, array.size - 1);
        var items = array.collect{|item|
            var size = max(1, item.size - 1);
            LinSelectX.perform(selector, size*select.y, item) 
        };
        ^LinSelectX.perform(selector, size*select.x, items);
    }

    *ar {|select, array|
        ^this.new(\audio, select.asPoint, array)
    }

    *kr {|select, array| 
        ^this.new(\control, select.asPoint, array)
    }
}
