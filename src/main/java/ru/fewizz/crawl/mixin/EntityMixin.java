package ru.fewizz.crawl.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.fewizz.crawl.Crawl;

@Mixin(Entity.class)
public class EntityMixin {

	@Inject(
		require = 1,
		method = "getJumpVelocityMultiplier",
		at = @At("RETURN"),
		cancellable = true
	)
	void onGetJumpVelocityMultiplierReturn(CallbackInfoReturnable<Float> cir) {
		if(( (Entity) ( (Object)this )).getPose() == Crawl.Shared.CRAWLING)
			cir.setReturnValue(cir.getReturnValueF()/2f);
	}

}
