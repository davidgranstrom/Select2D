// crossfade between objects in a two-dimensional space
// dkg 2012
//
Select2D {

    *new {|rate, select, array|
		var selector = UGen.methodSelectorForRate(rate);
        var size = array.size;
        var items = array.collect{|item|
            var size = item.size;
            SelectX.perform(
                selector, 
                size*select.x, 
                item
            ) 
        };
        ^SelectX.perform(selector, size*select.y, items);
    }

    *ar {|select, array, focus=1|
        ^this.new(\audio, select.asPoint, array, focus)
    }

    *kr {|select, array, focus=1| 
        ^this.new(\control, select.asPoint, array, focus)
    }
}
